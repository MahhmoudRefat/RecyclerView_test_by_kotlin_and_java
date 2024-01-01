package com.example.whatsapp_contact_recyclerview;

public class contact {
    int id;
    String name;
    String status;

    public contact(int id, String name, String status, int image_id) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.image_id = image_id;
    }

    int image_id;
}
