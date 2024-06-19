(ns exercism-clojure.proverb
  (:require [clojure.string :as str]))

(defn proverb
  [s1 s2]
  (str "For want of a " s1 " the " s2 " was lost."))

(defn last-proverb
  [s]
  (str "And all for the want of a " s "."))

(defn rhyme
  [[s1 s2]]
  (proverb s1 s2))

(defn add-last-proverb
  [s inputs]
  (conj inputs (last-proverb s)))

(defn recite
  [inputs]
  (if (empty? inputs)
    ""
    (->> inputs
         (partition 2 1)
         (mapv rhyme)
         (add-last-proverb (first inputs))
         (str/join "\n")
         ))
  )

(println (recite ["nail", "shoe", "horse", "rider", "message", "battle", "kingdom"]))
(println (recite []))
