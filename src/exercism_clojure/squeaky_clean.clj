(ns exercism-clojure.squeakyClean
  (:require [clojure.string :as str]))

(defn control-char?
  [c]
  (let [code (int c)]
    (or (<= code 0x001F)
        (and (>= code 0x007F) (<= code 0x009F)))))

(defn replace-by-dash
  [s]
  (str/replace s #"\s" "_"))

(defn filter-by-is-letter
  [c]
  (or (string? c)
      (= c \_)
      (Character/isLetter c)))

(defn replace-all-not-greek-letters
  [s]
  (str/replace s #"[α-ω]" ""))

(defn convert-kebab-in-camel-case
  [s]
  (println s)
  (->> (str/split s #"[-]")
       (map-indexed (fn [idx part]
                      (if (zero? idx) part (apply str (Character/toUpperCase (first part)) (rest part)))))
       (apply str)))

(defn replace-control-chars-by-CTRL
  [s]
  (map #(if (control-char? %) "CTRL" %) s))

(defn clean
  "TODO: add docstring"
  [s]
  (->> s
       replace-by-dash
       convert-kebab-in-camel-case
       replace-control-chars-by-CTRL
       (filter filter-by-is-letter)
       (apply str)
       replace-all-not-greek-letters))

;(println (clean "à-ḃç my   Id my\u007FId 1\uD83D\uDE002\uD83D\uDE003\uD83D\uDE00 MyΟβιεγτFinder"))
(println "clean" (clean "9 -abcĐ\uD83D\uDE00ω"))
