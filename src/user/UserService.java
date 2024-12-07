package user;

import input.InputHandler;

public class UserService {

        public static void addNewMember(){
            String name = addNewMember("Please enter the name of the new member: ");
            System.out.println("Thanks for adding " + name + "!");
        }


        public static String addNewMember(String enterName){
            System.out.println(enterName);
            String name = InputHandler.getFirstName();
            return name;
        }
//
//        public static Member findMember(){
//            System.out.println("Enter the name of the member you wish to find: ");
//            String input = InputHandler.getString();
//            boolean memberFound = false;
//            Member queriedName = null;
//            for(Member member : Library.getMembers()){
//                if(member.getName().equals(input)){
//                    queriedName = member;
//                    memberFound = true;
//                    break;
//                }
//            }
//            if(!memberFound){
//                System.out.println("Member not found. Do you want to add a new member? Y/N");
//                boolean signup = InputHandler.getBoolean();
//                if(signup){
//                    addNewMemberAsAdmin();
//                }
//            } else {
//                return queriedName;
//            }
//            return queriedName;
//        }
//
//        public static boolean isMember(String input){
//            boolean isMember = false;
//            for(Member member : Library.getMembers()){
//                if(member.getName().equals(input)){
//                    isMember = true;
//                    break;
//                }
//            }
//            return isMember;
//        }
//
//        public static void setCurrentVisitor(String member){
//            for (Member mem : Library.getMembers()) {
//                if(mem.getName().equals(member)){
//                    CurrentVisitor.setCurrentvisitor(mem);
//                }
//            }
//        }
//
//
//        public static void viewAllMembers(){
//            Library.getMembers().forEach(m -> System.out.println(m.toStringAdmin()));
//        }
//
//        public static void viewMembership(){
//            System.out.println(CurrentVisitor.getCurrentvisitor().toString());
//        }
//
    }
//