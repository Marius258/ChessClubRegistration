package com.marius.lt.ChessClubRegistration.controllers;

import com.marius.lt.ChessClubRegistration.services.ChessPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/chess_player")
public class ChessPlayerController {

    @Autowired
    public ChessPlayerService chessPlayerService;
}
