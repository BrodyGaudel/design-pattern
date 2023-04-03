package com.brody;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("/");
        root.addChild(new File("Main.java"));

        Folder entities = (Folder) root.addChild(new Folder("entities"));
        entities.addChild(new File("User.java"));
        entities.addChild(new File("Role.java"));

        Folder repositories = (Folder) root.addChild(new Folder("repositories"));
        repositories.addChild(new File("UserRepository.java"));
        repositories.addChild(new File("RoleRepository.java"));

        Folder services = (Folder) root.addChild(new Folder("service"));
        services.addChild(new File("UserService.java"));
        services.addChild(new File("RoleService.java"));

        Folder implementation = (Folder) services.addChild(new Folder("implementation"));
        implementation.addChild(new File("UserServiceImpl.java"));
        implementation.addChild(new File("RoleServiceImpl.java"));

        Folder restController = (Folder) root.addChild(new Folder("restcontroller"));
        restController.addChild(new File("UserRestController.java"));
        restController.addChild(new File("RoleRestController.java"));

        root.print();


    }


}