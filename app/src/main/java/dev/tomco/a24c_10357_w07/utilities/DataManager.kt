package dev.tomco.a24c_10357_w07.utilities


import dev.tomco.a24c_10357_w07.models.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DataManager {
    fun generateMovieList(): List<Movie> {
        val movies = mutableListOf<Movie>()
        movies
            .add(
                Movie
                    .Builder()
                    .name("Wonka")
                    .genre(ArrayList(mutableListOf("Comedy", "Family", "Fantasy")))
                    .actors(
                        ArrayList(
                            mutableListOf(
                                "Timothée Chalamet",
                                "Calah Lane",
                                "Keegan-Michael Key",
                                "Hugh Grant"
                            )
                        )
                    )
                    .length(117)
                    .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qhb1qOilapbapxWQn9jtRCMwXJF.jpg")
                    .overview("Willy Wonka - chock-full of ideas and determined to change the world one delectable bite at a time - is proof that the best things in life begin with a dream, and if you're lucky enough to meet Willy Wonka, anything is possible.")
                    .rating(7.2f)
                    .releaseDate(

                        "13/12/2023"


                    )
                    .build()
            )

        movies.add(
            Movie.Builder()
                .name("Deadpool & Wolverine")
                .genre(ArrayList(mutableListOf("Action", "Comedy", "Science Fiction")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Ryan Reynolds",
                            "Hugh Jackman",
                            "Morena Baccarin",
                            "Emma Corrin"
                        )
                    )
                )
                .length(119)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uxBHXaoOvAwy4NpPpP7nNx2rXYQ.jpg")
                .overview("Third entry in the \"Deadpool\" franchise. Plot TBA.")
                .rating(0.0f)
                .releaseDate(

                    "25/07/2024"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("The Marvels")
                .genre(ArrayList(mutableListOf("Science Fiction", "Adventure", "Action")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Brie Larson",
                            "Teyonah Parris",
                            "Iman Vellani",
                            "Samuel L. Jackson"
                        )
                    )
                )
                .length(105)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg")
                .overview("Carol Danvers, aka Captain Marvel, has reclaimed her identity from the tyrannical Kree and taken revenge on the Supreme Intelligence. But unintended consequences see Carol shouldering the burden of a destabilized universe. When her duties send her to an anomalous wormhole linked to a Kree revolutionary, her powers become entangled with that of Jersey City super-fan Kamala Khan, aka Ms. Marvel, and Carol’s estranged niece, now S.A.B.E.R. astronaut Captain Monica Rambeau. Together, this unlikely trio must team up and learn to work in concert to save the universe.")
                .rating(6.3f)
                .releaseDate(

                    "16/11/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Aquaman and the Lost Kingdom")
                .genre(ArrayList(mutableListOf("Action", "Adventure", "Fantasy")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Jason Momoa",
                            "Patrick Wilson",
                            "Yahya Abdul-Mateen II",
                            "Nicole Kidman"
                        )
                    )
                )
                .length(124)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7lTnXOy0iNtBAdRP3TZvaKJ77F6.jpg")
                .overview("Black Manta seeks revenge on Aquaman for his father's death. Wielding the Black Trident's power, he becomes a formidable foe. To defend Atlantis, Aquaman forges an alliance with his imprisoned brother. They must protect the kingdom.")
                .rating(6.9f)
                .releaseDate(

                    "21/12/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("The Hunger Games: The Ballad of Songbirds & Snakes")
                .genre(ArrayList(mutableListOf("Drama", "Science Fiction", "Action")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Tom Blyth",
                            "Rachel Zegler",
                            "Hunter Schafer",
                            "Peter Dinklage"
                        )
                    )
                )
                .length(157)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg")
                .overview("64 years before he becomes the tyrannical president of Panem, Coriolanus Snow sees a chance for a change in fortunes when he mentors Lucy Gray Baird, the female tribute from District 12.")
                .rating(7.2f)
                .releaseDate(

                    "07/12/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Oppenheimer")
                .genre(ArrayList(mutableListOf("Drama", "History")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Cillian Murphy",
                            "Emily Blunt",
                            "Matt Damon",
                            "Robert Downey Jr."
                        )
                    )
                )
                .length(181)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ptpr0kGAckfQkJeJIt8st5dglvd.jpg")
                .overview("The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.")
                .rating(8.1f)
                .releaseDate(

                    "20/07/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Guardians of the Galaxy Vol. 3")
                .genre(ArrayList(mutableListOf("Science Fiction", "Adventure", "Action")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Chris Pratt",
                            "Zoe Saldaña",
                            "Dave Bautista",
                            "Karen Gillan"
                        )
                    )
                )
                .length(150)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/r2J02Z2OpNTctfOSN1Ydgii51I3.jpg")
                .overview("Peter Quill, still reeling from the loss of Gamora, must rally his team around him to defend the universe along with protecting one of their own. A mission that, if not completed successfully, could quite possibly lead to the end of the Guardians as we know them.")
                .rating(8.0f)
                .releaseDate(

                    "03/05/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("The Iron Claw")
                .genre(ArrayList(mutableListOf("History", "Drama")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Zac Efron",
                            "Jeremy Allen White",
                            "Harris Dickinson",
                            "Maura Tierney"
                        )
                    )
                )
                .length(132)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nfs7DCYhgrEIgxKYbITHTzKsggf.jpg")
                .overview("The true story of the inseparable Von Erich brothers, who made history in the intensely competitive world of professional wrestling in the early 1980s. Through tragedy and triumph, under the shadow of their domineering father and coach, the brothers seek larger-than-life immortality on the biggest stage in sports.")
                .rating(7.5f)
                .releaseDate(

                    "11/01/2024"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Elemental")
                .genre(
                    ArrayList(
                        mutableListOf(
                            "Animation",
                            "Comedy",
                            "Family",
                            "Fantasy",
                            "Romance",
                            "Adventure"
                        )
                    )
                )
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Leah Lewis",
                            "Mamoudou Athie",
                            "Ronnie del Carmen",
                            "Shila Ommi"
                        )
                    )
                )
                .length(102)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4Y1WNkd88JXmGfhtWR7dmDAo1T2.jpg")
                .overview("In a city where fire, water, land and air residents live together, a fiery young woman and a go-with-the-flow guy will discover something elemental: how much they have in common.")
                .rating(7.7f)
                .releaseDate(

                    "15/06/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("The Flash")
                .genre(ArrayList(mutableListOf("Action", "Adventure", "Science Fiction")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Ezra Miller",
                            "Sasha Calle",
                            "Michael Keaton",
                            "Michael Shannon"
                        )
                    )
                )
                .length(144)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg")
                .overview("When his attempt to save his family inadvertently alters the future, Barry Allen becomes trapped in a reality in which General Zod has returned and there are no Super Heroes to turn to. In order to save the world that he is in and return to the future that he knows, Barry's only hope is to race for his life. But will making the ultimate sacrifice be enough to reset the universe?")
                .rating(6.8f)
                .releaseDate(

                    "14/06/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Barbie")
                .genre(ArrayList(mutableListOf("Comedy", "Adventure")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Margot Robbie",
                            "Ryan Gosling",
                            "America Ferrera",
                            "Kate McKinnon"
                        )
                    )
                )
                .length(114)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg")
                .overview("Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.")
                .rating(7.1f)
                .releaseDate(

                    "20/07/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Argylle")
                .genre(ArrayList(mutableListOf("Comedy", "Action", "Crime")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Bryce Dallas Howard",
                            "Henry Cavill",
                            "Bryan Cranston",
                            "Catherine O'Hara"
                        )
                    )
                )
                .length(139)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/siduVKgOnABO4WH4lOwPQwaGwJp.jpg")
                .overview("When the plots of reclusive author Elly Conway's fictional espionage novels begin to mirror the covert actions of a real-life spy organization, quiet evenings at home become a thing of the past. Accompanied by her cat Alfie and Aiden, a cat-allergic spy, Elly races across the world to stay one step ahead of the killers as the line between Conway's fictional world and her real one begins to blur.")
                .rating(6.2f)
                .releaseDate(

                    "01/02/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("Gran Turismo")
                .genre(ArrayList(mutableListOf("Adventure", "Action", "Drama")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "Archie Madekwe",
                            "David Harbour",
                            "Orlando Bloom",
                            "Darren Barnet"
                        )
                    )
                )
                .length(135)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/51tqzRtKMMZEYUpSYkrUE7v9ehm.jpg")
                .overview("The ultimate wish-fulfillment tale of a teenage Gran Turismo player whose gaming skills won him a series of Nissan competitions to become an actual professional racecar driver.")
                .rating(7.9f)
                .releaseDate(

                    "09/08/2023"


                ).build()
        )

        movies.add(
            Movie.Builder()
                .name("גן קופים")
                .genre(ArrayList(mutableListOf("Drama", "Comedy")))
                .actors(
                    ArrayList(
                        mutableListOf(
                            "אדיר מילר",
                            "סוזנה פפיאן",
                            "שני כהן",
                            "יניב ביטון"
                        )
                    )
                )
                .length(121)
                .poster("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eQo3U1EIreDefbEmlqa9hiUQDcw.jpg")
                .overview("סופר ישראלי שספריו זכו להצלחה גדולה בשנות ה-60 ומאז הקריירה שלו בדעיכה מזהה שזוהי שעת הכושר לצאת למלחמה על מקומו הראוי בקאנון הספרות הישראלי. הוא רוקם תוכנית מתוחכמת אך לא ממש מוסרית. אל מערבולת המזימה רבת התהפוכות שלו נסחפים אלמנה חייכנית, קיבוצניק שנושא עימו סוד גדול, שחקנית צעירה אך כושלת, מבקר ספרות חד לשון, במאי קולנוע איטלקי הנושא סוד משלו ומפיקה צעירה ואמביציוזית. המפגש הגורלי בין שלל הדמויות הססגוניות, ישנה לעד את מהלך חייו של הסופר ושל כל אחד מהדמויות האחרות")
                .rating(6.8f)
                .releaseDate(
                    "28/09/2023"
                ).build()
        )
        return movies

    }
}
