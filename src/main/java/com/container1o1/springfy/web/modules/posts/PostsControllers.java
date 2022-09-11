package com.container1o1.springfy.web.modules.posts;

import com.container1o1.springfy.service.posts.PostsService;
import com.container1o1.springfy.web.modules.posts.dto.PostsResponseDto;
import com.container1o1.springfy.web.modules.posts.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsControllers {

    private final PostsService postsService;

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }


    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/posts")
    public List<PostsResponseDto> findAll() {
        return postsService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
