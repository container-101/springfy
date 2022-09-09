package com.container1o1.springfy.web.modules.hello.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerDtoTest {

    @Test
    public void lombok_test() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
