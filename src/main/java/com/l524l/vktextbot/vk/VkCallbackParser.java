package com.l524l.vktextbot.vk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.l524l.vktextbot.exсeptions.vk.VkCallbackParsingException;
import com.vk.api.sdk.objects.audio.Audio;
import com.vk.api.sdk.objects.board.TopicComment;
import com.vk.api.sdk.objects.callback.*;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.video.Video;
import com.vk.api.sdk.objects.wall.WallComment;
import com.vk.api.sdk.objects.wall.Wallpost;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class VkCallbackParser {

    private Gson gson;

    private static final String CALLBACK_EVENT_MESSAGE_NEW = "message_new";
    private static final String CALLBACK_EVENT_MESSAGE_REPLY = "message_reply";
    private static final String CALLBACK_EVENT_MESSAGE_ALLOW = "message_allow";
    private static final String CALLBACK_EVENT_MESSAGE_DENY = "message_deny";
    private static final String CALLBACK_EVENT_MESSAGE_EDIT = "message_edit";
    private static final String CALLBACK_EVENT_PHOTO_NEW = "photo_new";
    private static final String CALLBACK_EVENT_PHOTO_COMMENT_NEW = "photo_comment_new";
    private static final String CALLBACK_EVENT_PHOTO_COMMENT_EDIT = "photo_comment_edit";
    private static final String CALLBACK_EVENT_PHOTO_COMMENT_RESTORE = "photo_comment_restore";
    private static final String CALLBACK_EVENT_PHOTO_COMMENT_DELETE = "photo_comment_delete";
    private static final String CALLBACK_EVENT_AUDIO_NEW = "audio_new";
    private static final String CALLBACK_EVENT_VIDEO_NEW = "video_new";
    private static final String CALLBACK_EVENT_VIDEO_COMMENT_NEW = "video_comment_new";
    private static final String CALLBACK_EVENT_VIDEO_COMMENT_EDIT = "video_comment_edit";
    private static final String CALLBACK_EVENT_VIDEO_COMMENT_RESTORE = "video_comment_restore";
    private static final String CALLBACK_EVENT_VIDEO_COMMENT_DELETE = "video_comment_delete";
    private static final String CALLBACK_EVENT_WALL_POST_NEW = "wall_post_new";
    private static final String CALLBACK_EVENT_WALL_REPOST = "wall_repost";
    private static final String CALLBACK_EVENT_WALL_REPLY_NEW = "wall_reply_new";
    private static final String CALLBACK_EVENT_WALL_REPLY_EDIT = "wall_reply_edit";
    private static final String CALLBACK_EVENT_WALL_REPLY_RESTORE = "wall_reply_restore";
    private static final String CALLBACK_EVENT_WALL_REPLY_DELETE = "wall_reply_delete";
    private static final String CALLBACK_EVENT_BOARD_POST_NEW = "board_post_new";
    private static final String CALLBACK_EVENT_BOARD_POST_EDIT = "board_post_edit";
    private static final String CALLBACK_EVENT_BOARD_POST_RESTORE = "board_post_restore";
    private static final String CALLBACK_EVENT_BOARD_POST_DELETE = "board_post_delete";
    private static final String CALLBACK_EVENT_MARKET_COMMENT_NEW = "market_comment_new";
    private static final String CALLBACK_EVENT_MARKET_COMMENT_EDIT = "market_comment_edit";
    private static final String CALLBACK_EVENT_MARKET_COMMENT_RESTORE = "market_comment_restore";
    private static final String CALLBACK_EVENT_MARKET_COMMENT_DELETE = "market_comment_delete";
    private static final String CALLBACK_EVENT_GROUP_LEAVE = "group_leave";
    private static final String CALLBACK_EVENT_GROUP_JOIN = "group_join";
    private static final String CALLBACK_EVENT_GROUP_CHANGE_SETTINGS = "group_change_settings";
    private static final String CALLBACK_EVENT_GROUP_CHANGE_PHOTO = "group_change_photo";
    private static final String CALLBACK_EVENT_GROUP_OFFICERS_EDIT = "group_officers_edit";
    private static final String CALLBACK_EVENT_POLL_VOTE_NEW = "poll_vote_new";
    private static final String CALLBACK_EVENT_USER_BLOCK = "user_block";
    private static final String CALLBACK_EVENT_USER_UNBLOCK = "user_unblock";
    private final static Map<String, Type> CALLBACK_TYPES;

    static {
        Map<String, Type> types = new HashMap<>();
        types.put(CALLBACK_EVENT_MESSAGE_NEW, new TypeToken<CallbackMessage<Message>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MESSAGE_REPLY, new TypeToken<CallbackMessage<Message>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MESSAGE_EDIT, new TypeToken<CallbackMessage<Message>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MESSAGE_ALLOW, new TypeToken<CallbackMessage<MessageAllow>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MESSAGE_DENY, new TypeToken<CallbackMessage<MessageDeny>>() {
        }.getType());

        types.put(CALLBACK_EVENT_PHOTO_NEW, new TypeToken<CallbackMessage<Photo>>() {
        }.getType());
        types.put(CALLBACK_EVENT_PHOTO_COMMENT_NEW, new TypeToken<CallbackMessage<PhotoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_PHOTO_COMMENT_EDIT, new TypeToken<CallbackMessage<PhotoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_PHOTO_COMMENT_RESTORE, new TypeToken<CallbackMessage<PhotoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_PHOTO_COMMENT_DELETE, new TypeToken<CallbackMessage<PhotoCommentDelete>>() {
        }.getType());

        types.put(CALLBACK_EVENT_AUDIO_NEW, new TypeToken<CallbackMessage<Audio>>() {
        }.getType());

        types.put(CALLBACK_EVENT_VIDEO_NEW, new TypeToken<CallbackMessage<Video>>() {
        }.getType());
        types.put(CALLBACK_EVENT_VIDEO_COMMENT_NEW, new TypeToken<CallbackMessage<VideoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_VIDEO_COMMENT_EDIT, new TypeToken<CallbackMessage<VideoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_VIDEO_COMMENT_RESTORE, new TypeToken<CallbackMessage<VideoComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_VIDEO_COMMENT_DELETE, new TypeToken<CallbackMessage<VideoCommentDelete>>() {
        }.getType());

        types.put(CALLBACK_EVENT_WALL_POST_NEW, new TypeToken<CallbackMessage<Wallpost>>() {
        }.getType());
        types.put(CALLBACK_EVENT_WALL_REPOST, new TypeToken<CallbackMessage<Wallpost>>() {
        }.getType());

        types.put(CALLBACK_EVENT_WALL_REPLY_NEW, new TypeToken<CallbackMessage<WallComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_WALL_REPLY_EDIT, new TypeToken<CallbackMessage<WallComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_WALL_REPLY_RESTORE, new TypeToken<CallbackMessage<WallComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_WALL_REPLY_DELETE, new TypeToken<CallbackMessage<WallCommentDelete>>() {
        }.getType());

        types.put(CALLBACK_EVENT_BOARD_POST_NEW, new TypeToken<CallbackMessage<TopicComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_BOARD_POST_EDIT, new TypeToken<CallbackMessage<TopicComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_BOARD_POST_RESTORE, new TypeToken<CallbackMessage<TopicComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_BOARD_POST_DELETE, new TypeToken<CallbackMessage<BoardPostDelete>>() {
        }.getType());

        types.put(CALLBACK_EVENT_MARKET_COMMENT_NEW, new TypeToken<CallbackMessage<MarketComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MARKET_COMMENT_EDIT, new TypeToken<CallbackMessage<MarketComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MARKET_COMMENT_RESTORE, new TypeToken<CallbackMessage<MarketComment>>() {
        }.getType());
        types.put(CALLBACK_EVENT_MARKET_COMMENT_DELETE, new TypeToken<CallbackMessage<MarketCommentDelete>>() {
        }.getType());

        types.put(CALLBACK_EVENT_GROUP_LEAVE, new TypeToken<CallbackMessage<GroupLeave>>() {
        }.getType());
        types.put(CALLBACK_EVENT_GROUP_JOIN, new TypeToken<CallbackMessage<GroupJoin>>() {
        }.getType());
        types.put(CALLBACK_EVENT_GROUP_CHANGE_SETTINGS, new TypeToken<CallbackMessage<GroupChangeSettings>>() {
        }.getType());
        types.put(CALLBACK_EVENT_GROUP_CHANGE_PHOTO, new TypeToken<CallbackMessage<GroupChangePhoto>>() {
        }.getType());
        types.put(CALLBACK_EVENT_GROUP_OFFICERS_EDIT, new TypeToken<CallbackMessage<GroupOfficersEdit>>() {
        }.getType());
        types.put(CALLBACK_EVENT_USER_BLOCK, new TypeToken<CallbackMessage<UserBlock>>() {
        }.getType());
        types.put(CALLBACK_EVENT_USER_UNBLOCK, new TypeToken<CallbackMessage<UserUnblock>>() {
        }.getType());

        types.put(CALLBACK_EVENT_POLL_VOTE_NEW, new TypeToken<CallbackMessage<PollVoteNew>>() {
        }.getType());

        CALLBACK_TYPES = Collections.unmodifiableMap(types);
    }


    public VkCallbackParser(Gson gson) {
        this.gson = gson;
    }

    public CallbackMessage<?> parse(String json) throws VkCallbackParsingException {
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        return parse(jsonObject);
    }

    public CallbackMessage<?> parse(JsonObject json) throws VkCallbackParsingException {
        String type = json.get("type").getAsString();
        Type typeOfClass = CALLBACK_TYPES.get(type);

        if (typeOfClass == null) {
            throw new VkCallbackParsingException();
        }

        return gson.fromJson(json, typeOfClass);
    }
}
