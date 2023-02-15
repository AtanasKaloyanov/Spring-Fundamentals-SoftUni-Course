package com.likebookapp.service;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.dto.PostsDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodsEnum;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {
    private final PostRepository postRepository;
    private final MoodServiceImpl moodService;

    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, MoodServiceImpl moodService, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.moodService = moodService;
        this.userRepository = userRepository;
    }

    public Post mapPost(AddPostDTO addPostDTO) {
        Post post = new Post();
        post.setContent(addPostDTO.getContent());

        MoodsEnum moodsEnum = addPostDTO.getMoodsName();
        Mood mood = this.moodService.findMoodByMoodName(moodsEnum);
        post.setMood(mood);

        User user = this.userRepository.findById(addPostDTO.getId()).orElse(null);
        post.setUser(user);

        return post;
    }

    public void savePosts(AddPostDTO addPostDTO) {
        Post post = mapPost(addPostDTO);
        this.postRepository.save(post);
    }

    public Set<Post> getPostsFromUserById(Long id) {
        return this.postRepository.findAllByUserId(id);
    }

    public Set<PostsDTO> getPostsDTOSnotByUserID(Long id) {
           Set<Post> findAllByUserIdNot = this.postRepository.findAllByUserIdNot(id);

           Set<PostsDTO> postsDTOS = findAllByUserIdNot.stream().map(
                   currentPost -> {
                       PostsDTO postsDTO = new PostsDTO();
                       postsDTO.setId(currentPost.getId());
                       postsDTO.setContent(currentPost.getContent());
                       postsDTO.setMood(currentPost.getMood());
                       postsDTO.setUser(currentPost.getUser());
                       postsDTO.setUserLikes(currentPost.getUserLikes());
                       postsDTO.setLikes(currentPost.getLikes());

                       return postsDTO;
                   }).collect(Collectors.toSet());

                  return postsDTOS;
    }

    public void initPosts() {

        User admin = this.userRepository.findById(Long.parseLong("1")).orElse(null);

        Post firstAdminPost = new Post();
        firstAdminPost.setContent("aa");
        firstAdminPost.setMood(moodService.findMoodByMoodName(MoodsEnum.HAPPY));
        firstAdminPost.setUser(admin);
        firstAdminPost.setLikes(7);

        Post secondAdminPost = new Post();
        secondAdminPost.setContent("bb");
        secondAdminPost.setMood(moodService.findMoodByMoodName(MoodsEnum.SAD));
        secondAdminPost.setUser(admin);
        secondAdminPost.setLikes(2);

        User test = this.userRepository.findById(Long.parseLong("2")).orElse(null);

        Post firstTestPost = new Post();
        firstTestPost.setContent("cc");
        firstTestPost.setMood(moodService.findMoodByMoodName(MoodsEnum.HAPPY));
        firstTestPost.setUser(test);
        firstTestPost.setLikes(3);

        Post secondTestPost = new Post();
        secondTestPost.setContent("dd");
        secondTestPost.setMood(moodService.findMoodByMoodName(MoodsEnum.SAD));
        secondTestPost.setUser(test);
        secondTestPost.setLikes(4);

        this.postRepository.save(firstAdminPost);
        this.postRepository.save(secondAdminPost);
        this.postRepository.save(firstTestPost);
        this.postRepository.save(secondTestPost);
    }

    public void removePostById(Long id) {
        this.postRepository.deleteById(id);
    }

    public void addLikeById(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
    }
}
