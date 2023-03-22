package com.abcfitness.addressverification.address;

import com.abcfitness.addressverification.address.entity.AvalaraResponseMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvalaraResponseVO {


    private Date created;
    private List<AvalaraMessageVO> messages;

    AvalaraResponseVO (Date created, List<AvalaraResponseMessage> avalaraResponseMessages){
        this.created = created;
        this.messages = new ArrayList<>();
        for (AvalaraResponseMessage message : avalaraResponseMessages){
            messages.add(new AvalaraMessageVO(message));
        }
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<AvalaraMessageVO> getMessages() {
        return messages;
    }

    public void setMessages(List<AvalaraMessageVO> messages) {
        this.messages = messages;
    }
}
