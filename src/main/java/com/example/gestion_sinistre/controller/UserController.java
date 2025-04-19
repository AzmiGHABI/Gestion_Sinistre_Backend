//package com.example.gestion_sinistre.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @GetMapping("/public")
//    public String publicEndpoint() {
//        return "Ceci est un endpoint public.";
//    }
//
//    @GetMapping("/expert")
//    @PreAuthorize("hasRole('expert')")
//    public String expertEndpoint() {
//        return "Bienvenue, Expert !";
//    }
//
//    @GetMapping("/gestionnaire")
//    @PreAuthorize("hasRole('gestionnaire')")
//    public String gestionnaireEndpoint() {
//        return "Bienvenue, Gestionnaire !";
//    }
//}
