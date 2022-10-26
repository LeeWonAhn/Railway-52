import entity.Group;
import repository.GroupRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupRepository groupRepository = new GroupRepository();

        System.out.println("-----Creqte-----");
        Group group1 = new Group();
        group1.setName("Marketing");
        groupRepository.createGroup(group1);

        Group group2 = new Group();
        group2.setName("DEV");
        groupRepository.createGroup(group2);

        System.out.println("-----GET ALL-----");
        List<Group> goups = groupRepository.getAllGroups();
        for (Group group : goups) {
            System.out.println("group = " + group);
        }

        System.out.println("-----GET BY ID-----");
        Group groupByID = groupRepository.getGroupByID(1);
        System.out.println("groupByID = " + groupByID);

        System.out.println("-----GET BY NAME-----");
        Group groupByName = groupRepository.getGroupByName("Marketing");
        System.out.println("groupByName = " + groupByName);

        System.out.println("-----UPDATE-----");
        groupByID.setName("FRONT-END");
        groupRepository.updateGroup(groupByID);

        System.out.println("-----DELETE-----");
        groupRepository.deleteGroup(1);
    }
}
