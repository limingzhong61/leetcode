package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        while (cin.hasNextLine()) {
            String line = cin.nextLine();
            String[] split = line.split(",");

            String[] result = new String[split.length];
            int idx = 0;
            for(String s : split){
                StringBuilder sb = new StringBuilder();
                for(int j = s.length() - 1; j >= 0; j--){
                    if(s.charAt(j) != ':'){
                        sb.append(s.charAt(j));
                    }
                    result[idx++] = sb.toString();
                }
            }

            Person person = new Person(result[0], Integer.valueOf(result[1]), result[2], Integer.valueOf(result[3].substring(0,result[3].length()-2)),
                    Integer.valueOf(result[4].substring(0,result[4].length()-2)));
            list.add(person);
        }
        List<Person> collect = list.stream().filter(p -> p.age >= 18).collect(Collectors.toList());
        System.out.println(collect);
        int max = list.get(0).age,min = list.get(0).age;
        double avg = 0;
        for(int i = 0; i < list.size(); i++){
            max = Math.max(max,list.get(i).age);
            avg += list.get(i).age;
            min = Math.max(min,list.get(i).age);
        }
        avg /= list.size();
        System.out.printf("%f,%d,%d\n",avg,min,max);


        // 4
        list.sort((a,b) ->{
            if(a.age == b.age){
                return  b.height - a.height;
            }
            return b.age - a.age;
        });

        System.out.println(list);

        // 5
        int maxId = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).gender.equals("female") && list.get(i).age > list.get(maxId).age){
                maxId = i;
            }
        }
        System.out.println(list.get(maxId).age);


        // 6
        List<Person> filters = list.stream().filter(p -> p.age >= 20 && p.age <= 25 && p.weight >= 60 && p.weight < 80
        ).toList();
        filters.sort((a,b) -> b.height - a.height);
        System.out.println(filters.get(1));
        System.out.println(filters.get(2));
    }


}

class Person {
    String name;
    Integer age;
    String gender;
    Integer height;
    Integer weight;

    public Person(String name, Integer age, String gender, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
}