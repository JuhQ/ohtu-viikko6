package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
//
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//
//        for (Player player : stats.matches(m)) {
//            System.out.println("eka: " + player );
//        }
//
//        Matcher m2 = new Not( new HasAtLeast(1, "goals") );
//
//        for (Player player : stats.matches(m2)) {
//            System.out.println("toka lista: " + player );
//        }
//        
//        Matcher m3 = new Or( new HasAtLeast(40, "goals"),
//                    new HasAtLeast(60, "assists"),
//                    new HasAtLeast(85, "points")
//        );
//
//        for (Player player : stats.matches(m3)) {
//            System.out.println("kolmas lista: " + player );
//        }
//        
//        Matcher m4 = new HasFewerThan(1, "goals");  
//
//        for (Player player : stats.matches(m4)) {
//            System.out.println("neljäs lista: " + player );
//        }
//        
        QueryBuilder query = new QueryBuilder();
//
//        Matcher m5 = query.playsIn("NYR")
//                         .hasAtLeast(10, "goals")
//                         .hasFewerThan(25, "assists").build();
//
//        for (Player player : stats.matches(m5)) {
//            System.out.println("viides lista: " + player );
//        }
//        
        Matcher m1 = query.playsIn("PHI")
                  .hasAtLeast(10, "goals")
                  .hasFewerThan(20, "assists").build();
 
        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(60, "points").build();

        Matcher m6 = query.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m6)) {
            System.out.println("kuudes lista: " + player );
        }
        
        Matcher m7 = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(20, "assists").build(),
 
                        query.playsIn("EDM")
                             .hasAtLeast(60, "points").build()
                       ).build();
        
        
        for (Player player : stats.matches(m7)) {
            System.out.println("seitsemäs lista: " + player );
        }
    }
}
