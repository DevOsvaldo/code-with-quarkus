package org.dcaat.drone.enums;



public enum DroneStatus {
    IDLE,//OCIOSO ou Parado
    TAKING_OFF,//Decolando
    FLYING,// Voando
    RETURNING_HOME,// Retornando para base
    LANDING,// Pouso
    CHARGING,// Carregando
    MAINTENANCE,// Manutenção
    ERROR // Erro
}
