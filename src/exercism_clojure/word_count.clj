(ns exercism-clojure.word_count
  (:require [clojure.string :as str]))

(def split-by-space (fn [s] (str/split s #" ")))

(def replace-break-line-by-empty (fn [s] (str/replace s #"\n" " ")))

;(println "teste" (replace-break-line-by-empty "a.\naa"))

(defn filter-by-letter-or-digit
  [s]
  (apply str (filter #(Character/isLetterOrDigit %) s)))

(defn word-count
  [s]
  (->> s
       replace-break-line-by-empty
       str/lower-case
       split-by-space
       (map filter-by-letter-or-digit)
       (filter (complement empty?))
       frequencies
       ))

;(println (word-count "\"That's the password: 'PASSWORD 123'!\", cried the Special Agent.\nSo I fled."))
(println (word-count "car : carpet as java : javascript!!&@$%^&"))
