//package org.example.exam24hbackend.controller;
//
//import jakarta.transaction.Transactional;
//import org.example.exam24hbackend.entity.Participant;
//import org.example.exam24hbackend.repository.ParticipantRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//class ParticipantControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ParticipantRepository participantRepository;
//
//    @BeforeEach
//    public void setUp() {
//        participantRepository.deleteAll();
//    }
//
//    @Test
//    void getAllParticipants() throws Exception {
//        Participant newParticipant1 = new Participant();
//        newParticipant1.setName("test person1");
//        newParticipant1.setAge(99);
//        newParticipant1.setGender("male");
//        newParticipant1.setClub("Club-Test1");
//
//        Participant newParticipant2 = new Participant();
//        newParticipant2.setName("test person2");
//        newParticipant2.setAge(99);
//        newParticipant2.setGender("female");
//        newParticipant2.setClub("Club-Test2");
//
//        participantRepository.save(newParticipant1);
//        participantRepository.save(newParticipant2);
//
//        mockMvc.perform(get("/api/participants/")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2));
//    }
//
//    @Test
//    void getParticipantById() throws Exception {
//        Participant newParticipant = new Participant();
//        newParticipant.setName("test person");
//        newParticipant.setAge(99);
//        newParticipant.setGender("male");
//        newParticipant.setClub("Club-Test");
//
//        newParticipant = participantRepository.save(newParticipant);
//
//        mockMvc.perform(get("/api/participants/" + newParticipant.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("test person"))
//                .andExpect(jsonPath("$.age").value(99))
//                .andExpect(jsonPath("$.gender").value("male"))
//                .andExpect(jsonPath("$.club").value("Club-Test"));
//    }
//
//    @Test
//    void createParticipant() throws Exception {
//        String participantJson = "{\"name\":\"test person\", \"age\":99, \"gender\":\"male\", \"club\":\"Club-Test\"}";
//
//        mockMvc.perform(post("/api/participants/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(participantJson))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("test person"))
//                .andExpect(jsonPath("$.age").value(99))
//                .andExpect(jsonPath("$.gender").value("male"))
//                .andExpect(jsonPath("$.club").value("Club-Test"));
//    }
//
//    @Test
//    void updateParticipant() throws Exception {
//        Participant newParticipant = new Participant();
//        newParticipant.setName("test person");
//        newParticipant.setAge(99);
//        newParticipant.setGender("male");
//        newParticipant.setClub("Club-Test");
//
//        newParticipant = participantRepository.save(newParticipant);
//
//        String updatedParticipantJson = "{\"name\":\"updated person\", \"age\":100, \"gender\":\"male\", \"club\":\"Updated-Club\"}";
//
//        mockMvc.perform(put("/api/participants/" + newParticipant.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(updatedParticipantJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("updated person"))
//                .andExpect(jsonPath("$.age").value(100))
//                .andExpect(jsonPath("$.gender").value("male"))
//                .andExpect(jsonPath("$.club").value("Updated-Club"));
//    }
//
//    @Test
//    void deleteParticipant() throws Exception {
//        Participant newParticipant = new Participant();
//        newParticipant.setName("test person");
//        newParticipant.setAge(99);
//        newParticipant.setGender("male");
//        newParticipant.setClub("Club-Test");
//
//        newParticipant = participantRepository.save(newParticipant);
//
//        mockMvc.perform(delete("/api/participants/" + newParticipant.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(get("/api/participants/" + newParticipant.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//}
