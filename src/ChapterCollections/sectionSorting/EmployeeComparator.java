package ChapterCollections.sectionSorting;

import java.util.Comparator;

public class EmployeeComparator {

   static String a ="11";

    public static Comparator<ProgrammerEmployee> employeeComparator(String pmSortingBy) {
        System.out.println(a);
          a = a.concat("2");

        System.out.println(a);
        return switch (pmSortingBy) {
            case "name" -> new SortByName();
            case "salary" -> new SortBySalary();
            case "age" -> new SortByAge();
            case "possition" -> new SortByPossition();
            default -> Comparator.naturalOrder();
        };
    }

    static class SortByName implements Comparator<ProgrammerEmployee> {

        @Override public int compare(ProgrammerEmployee o1, ProgrammerEmployee o2) {




            return o1.getOwnName()
                    .compareTo(o2.getOwnName());
        }

    }

    static class SortBySalary implements Comparator<ProgrammerEmployee> {

        @Override public int compare(ProgrammerEmployee o1, ProgrammerEmployee o2) {
            return o1.getOwnSalary()
                    .compareTo(o2.getOwnSalary());
        }

    }

    static class SortByAge implements Comparator<ProgrammerEmployee> {

        @Override
        public int compare(ProgrammerEmployee o1, ProgrammerEmployee o2) {
            return o1.getOwnSalary()
                    .compareTo(o2.getOwnSalary());
        }
    }

    static class SortByPossition implements Comparator<ProgrammerEmployee> {

        @Override
        public int compare(ProgrammerEmployee o1, ProgrammerEmployee o2) {

            return !o1.getPosition()
                    .equals(o2.getPosition()) ? o1.mapPossitionToIntValue() - o2.mapPossitionToIntValue() : o1.getOwnSalary()
                    .compareTo(o2.getOwnSalary());
        }
    }
}
