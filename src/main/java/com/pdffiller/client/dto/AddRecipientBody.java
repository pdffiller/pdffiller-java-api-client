package com.pdffiller.client.dto;

import java.util.*;

public class AddRecipientBody {
    private ArrayList<SignatureRequestBody.Recipient> recipients = new ArrayList<>();

    public void add(SignatureRequestBody.Recipient recipient) {
        recipients.add(recipient);
    }

    public ArrayList<SignatureRequestBody.Recipient> getRecipients() {
        return this.recipients;
    }
}
