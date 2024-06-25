(ns exercism_clojure.beer_song
  (:require [clojure.string :as str]))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (case num
    0 (str "No more bottles of beer on the wall, no more bottles of beer.\n"
           "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
    1 (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
           "Take it down and pass it around, no more bottles of beer on the wall.\n")
    (str num " bottles of beer on the wall, " num " bottles of beer.\n"
            "Take one down and pass it around, " (dec num) " bottle" (when (> (dec num) 1) "s") " of beer on the wall.\n")
    )
  )

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (->> (range end (inc start))
        reverse
        (map verse)
        (str/join "\n")
        )))

(println (sing 8 6))