(ns exercism-clojure.acronym
  (:require [clojure.string :as str]))

(defn split-phrase-by-space
  [phrase]
  (str/split phrase #" "))

(defn split-phrase-by-uppercase-letter
  [phrase]
  (str/split phrase #"(?=[A-Z])"))

(defn replace-dash-by-space
  [phrase]
  (str/replace phrase #"-" " "))

(defn remove-translation
  [s]
  (let [index-of (str/index-of s ":")]
    (subs s 0 (if index-of index-of (count s)))))

(defn join-phrase
  [phrase]
  (str/join phrase))

(defn get-first-letter
  [s]
  (first s))

(defn has-translation?
  [s]
  (str/includes? s ":"))


(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (cond
    (empty? phrase) phrase
    (has-translation? phrase) (remove-translation phrase)
    :else (->> phrase
               replace-dash-by-space
               split-phrase-by-space
               (map split-phrase-by-uppercase-letter)
               flatten
               (map get-first-letter)
               (map #(Character/toUpperCase %))
               join-phrase
               ))
  )

(println (acronym "Portable Network Graphics"))
(println (acronym "Complementary metal-oxide semiconductor"))
(println (acronym "PHP: Hypertext Preprocessor"))
