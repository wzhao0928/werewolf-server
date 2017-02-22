package com.werewolf.services;

import com.werewolf.GamePool;
import com.werewolf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class GameService {
    @Autowired
    private GamePool gamePool;

    public String fetchRole(String sessionId, String gameId, Integer seatId) {
        Game game = gamePool.getGameById(gameId);
        Queue<RoleType> playerQueue = game.getPlayerQueue();

        if(playerQueue.isEmpty()) {
            return "角色分配完毕";
        }
        RoleType roleType = playerQueue.poll();
        addPlayer(game, roleType, sessionId, seatId);
        return roleType.getDisplayName();
    }

    private void addPlayer(Game game, RoleType roleType, String sessionId, Integer seatId) {
//
//        Role role = new Role();
//        new Player(seatId, role);
    }
}
