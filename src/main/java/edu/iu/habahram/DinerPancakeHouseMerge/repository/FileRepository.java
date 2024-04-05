package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.User;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepository {
    public FileRepository() {
    }


    private String USER_DATABASE_FILE = "data/userDatabase.txt";
    private static final String NEW_LINE = System.lineSeparator();

    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public boolean add(User user) throws IOException {
        Path path = Paths.get(USER_DATABASE_FILE);

        String data = user.toLine();
        System.out.println(data);
        appendToFile(path, data + NEW_LINE);
        return true;
    }

    public User find(String username) throws IOException {
        List<User> users = findAll();
        for (User user : users) {
            if(user.username().equals(username)) {
                String password = user.password();
                if(user.password().equals(password)) {
                    return user;
                }
                else {
                    return null;
                }
            }
        }
        return null;
    }

    public List<User> findAll() throws IOException {
        List<User> users = new ArrayList<>();
        Path path = Paths.get(USER_DATABASE_FILE);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            User user = User.fromLine(line);
            users.add(user);
        }
        return users;
    }


}