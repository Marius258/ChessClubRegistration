package com.marius.lt.ChessClubRegistration.converters;

import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerDTO;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerEditDTO;
import com.marius.lt.ChessClubRegistration.dtos.ChessPlayerPayloadDTO;
import com.marius.lt.ChessClubRegistration.entities.ChessPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPlayerConverter {
    public static List<ChessPlayerDTO> convertChessPlayerEntityListToDto(List<ChessPlayer> chessPlayerList) {
        List<ChessPlayerDTO> chessPlayerDTOList = null;
        for (ChessPlayer cp : chessPlayerList) {
            if (chessPlayerDTOList == null) {
                chessPlayerDTOList = new ArrayList<>();
            }
            chessPlayerDTOList.add(convertChessPlayerEntityToDto(cp));
        }
        return chessPlayerDTOList;
    }

    public static ChessPlayerDTO convertChessPlayerEntityToDto(ChessPlayer chessPlayer) {
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

    public static ChessPlayer convertChessPlayerPayloadDtoToEntity(ChessPlayerPayloadDTO chessPlayerPayloadDTO) {
        ChessPlayer chessPlayer = null;
        if (chessPlayerPayloadDTO != null) {
            chessPlayer = new ChessPlayer();
            chessPlayer.setPin(chessPlayerPayloadDTO.getPin());
            chessPlayer.setName(chessPlayerPayloadDTO.getName());
            chessPlayer.setLastname(chessPlayerPayloadDTO.getLastname());
            chessPlayer.setEmail(chessPlayerPayloadDTO.getEmail());
            chessPlayer.setStartedPlaying(chessPlayerPayloadDTO.getStartedPlaying());
        }
        return chessPlayer;
    }

    public static ChessPlayer convertChessPlayerEditDtoToEntity(ChessPlayerEditDTO chessPlayerEditDTO) {
        ChessPlayer chessPlayer = null;
        if (chessPlayerEditDTO != null) {
            chessPlayer = new ChessPlayer();
            chessPlayer.setName(chessPlayerEditDTO.getName());
            chessPlayer.setLastname(chessPlayerEditDTO.getLastname());
            chessPlayer.setEmail(chessPlayerEditDTO.getEmail());
            chessPlayer.setStartedPlaying(chessPlayerEditDTO.getStartedPlaying());
        }
        return chessPlayer;
    }
}
