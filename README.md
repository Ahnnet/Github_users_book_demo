# Github_users_book_demo

## Content
This is an application that uses the github_users API to fetch and view various information of github users.

## Tech stack

### Network
- Retrofit2

### Image resource
- Glide

## API
- Github Users - [https://api.github.com/users](https://api.github.com/users)
    
    ```jsx
    {
        "login": "mojombo",
        "id": 1,
        "node_id": "MDQ6VXNlcjE=",
        "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
        "gravatar_id": "",
        "url": "https://api.github.com/users/mojombo",
        "html_url": "https://github.com/mojombo",
        "followers_url": "https://api.github.com/users/mojombo/followers",
        "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
        "gists_url": "https://api.github.com/users/mojombo/gists{/gist_id}",
        "starred_url": "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
        "subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
        "organizations_url": "https://api.github.com/users/mojombo/orgs",
        "repos_url": "https://api.github.com/users/mojombo/repos",
        "events_url": "https://api.github.com/users/mojombo/events{/privacy}",
        "received_events_url": "https://api.github.com/users/mojombo/received_events",
        "type": "User",
        "site_admin": false
      }
    ```
    
## Project usage and features

### Intro
<img src="https://github.com/Ahnnet/Github_users_book_demo/assets/93837441/ff2d2f4e-0dea-4006-acfa-6c7aea6bb332.png" width="200" height="400"/>

### User List Page
1. Expose userList in card format. (Grid Layout)
2. When the card was clicked, move to the corresponding user's Detail page.
<img src="https://github.com/Ahnnet/Github_users_book_demo/assets/93837441/55cfda51-5361-4301-b079-15806c0ad61c.png" width="200" height="400"/>


### User Detail Page
1. Expose basic information about users. (Name, User type)
2. When the 'GITHUB LINK' was clicked, move to the user's Github page.
3. When the 'FOLLOWERS' was clicked, expose the user's followers in card format.
<img src="https://github.com/Ahnnet/Github_users_book_demo/assets/93837441/d5aa3146-9860-4a1e-a026-8c4d8508ab44.png" width="200" height="400"/>


### Follower Page
1. Expose FollowerList in card format. (Grid Layout)
2. When the card was clicked, move to the corresponding follower's Detail Page.
<img src="https://github.com/Ahnnet/Github_users_book_demo/assets/93837441/ff84bb6a-f270-4c2b-a2cb-2b1e0a21acda.png" width="200" height="400"/>


## Unsolved Issues
1. Expose the 'Follower Number' in Follower Page.
    - In 'getItemCount' of 'RecyclerAdapter.kt', error while intent.putExtra(dataNum) to 'FollowersActivity.kt'.
    
