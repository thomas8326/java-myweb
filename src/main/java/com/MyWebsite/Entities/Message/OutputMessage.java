package com.MyWebsite.Entities.Message;

public class OutputMessage {

    private String roomId;
    private String msgId;
    private String content;
    private String senderId;

    private String date;


    public OutputMessage(String date, InputMessage message) {
        this.date = date;
        this.roomId = message.getRoomId();
        this.msgId = message.getMsgId();
        this.content = message.getContent();
        this.senderId = message.getSenderId();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}
