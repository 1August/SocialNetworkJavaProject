package com.example.socialnetwork.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAddToFriendsRequest {
    Integer userid;
    Integer requestedUserId;
}
