package com.example.SongPlaylist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SongPlaylistIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objMapper;
    @Test
    public void getAllPlaylist()
    {
        PlaylistDto playlistDto = new  PlaylistDto("name");
        mockMvc.perform(post("/playlist")
                .content(objMapper.writeValueAsString(playlistDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}
