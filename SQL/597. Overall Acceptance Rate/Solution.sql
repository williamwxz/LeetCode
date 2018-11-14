# Write your MySQL query statement below
Select ifnull(round(count(distinct requester_id,accepter_id)/count(distinct sender_id,send_to_id), 2), 0.0) as accept_rate
From request_accepted, friend_request
