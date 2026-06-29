package com.cognizant.mockito.exercise4;

public class NetworkService {

    private NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String connectToServer() {

        return "Connected to " + networkClient.connect();

    }

}