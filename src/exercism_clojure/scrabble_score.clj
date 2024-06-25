(ns exercism-clojure.scrabble_score
  (:require [clojure.string :as str]))


(defn score-letter [letter] ;; <- arglist goes here
  (case (str/lower-case letter)
    ("a" "e" "i" "o" "u" "l" "n" "r" "s" "t") 1
    ("d" "g") 2
    ("b" "c" "m" "p") 3
    ("f" "h" "v" "w" "y") 4
    "k" 5
    ("j" "x") 8
    10
    )
  )

(println (score-letter "a"))

(defn score-by-amount-letters [[letter amount]]
  (* (score-letter (str letter)) amount)
  )

(defn score-word [word] ;; <- arglist goes here
  (->> word
       frequencies
       (map score-by-amount-letters)
       (reduce + 0))
  )

(println (score-word "A"))