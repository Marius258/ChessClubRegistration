package com.marius.lt.ChessClubRegistration.converters;

import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerDTO;
import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPlayerConverter {
    public static List<ChessPlayerDTO> convertChessPlayerEntityListToDto(List<ChessPlayer> chessPlayerList) {
        List<ChessPlayerDTO> chessPlayerDTOList = null;
        for(ChessPlayer cp: chessPlayerList){
            if(chessPlayerDTOList == null){
                chessPlayerDTOList = new ArrayList<>();
            }
            chessPlayerDTOList.add(convertChessPlayerEntityToDto(cp));
        }
        return chessPlayerDTOList;
    }

    public static ChessPlayerDTO convertChessPlayerEntityToDto(ChessPlayer chessPlayer){
        ChessPlayerDTO chessPlayerDTO = null;
        if (chessPlayer != null) {
            chessPlayerDTO = new ChessPlayerDTO();
            chessPlayerDTO.setName(chessPlayer.getName());
            chessPlayerDTO.setLastname(chessPlayer.getLastname());
            chessPlayerDTO.setEmail(chessPlayer.getEmail());
            chessPlayerDTO.setAge(chessPlayer.getAge());
            chessPlayerDTO.setGender(chessPlayer.getGender());
            chessPlayerDTO.setTimeSinceStartedPlaying(chessPlayer.getTimeSinceStartedPlaying());
        }
        return chessPlayerDTO;
    }
}
