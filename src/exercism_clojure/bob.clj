(ns exercism_clojure.bob
  (:require [clojure.string :as str]))

(defn response-for
  [s]
  (let [trim-s (str/trim s)
        letters (filter #(Character/isLetter %) trim-s)
        letters-upper-case? (if (empty? letters) false (every? #(Character/isUpperCase %) letters))
        ends-with-question-mark? (str/ends-with? trim-s "?")]
    (println trim-s)
    (println (filter #(Character/isLetter %) trim-s) letters-upper-case?)
    (cond
      (empty? trim-s) "Fine. Be that way!"
      (and letters-upper-case? ends-with-question-mark?) "Calm down, I know what I'm doing!"
      ends-with-question-mark? "Sure."
      (and letters-upper-case? (not (empty? trim-s))) "Whoa, chill out!"
      :else "Whatever."
      ))
  )

(println (response-for "4?"))