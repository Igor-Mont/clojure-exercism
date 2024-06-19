(ns exercism-clojure.rotational_cipher
  (:require [clojure.string :as str]))

(defn shift-char-in-plain
  [char key]
  (println "char" char (class char))
  (if (Character/isLetter char)
    (let [plain "abcdefghijklmnopqrstuvwxyz"
          is-upper-case (Character/isUpperCase char)
          index-of-char (str/index-of plain (Character/toLowerCase char))
          shift-index (+ index-of-char key)
          exceeds-plain-size (> shift-index 25)
          index-of-cipher (if exceeds-plain-size (mod shift-index 26) shift-index)
          cipher (nth plain index-of-cipher)
          ]
      (println index-of-cipher (nth plain index-of-cipher))
      (if is-upper-case (Character/toUpperCase cipher) cipher)
      ) char)
  )

;(shift-char-in-plain  "z" 13)

(defn shift-plain-to-obtain-cipher
  [s key]
  (str/join (map #(shift-char-in-plain % key) s))
  )

;(println (shift-plain-to-obtain-cipher "abcdefghijklmnopqrstuvwxyz" 13))

(defn rotate
  [s key]
  (if (or (zero? key) (= key 26))
    s
    (shift-plain-to-obtain-cipher s key))
  )

(println (rotate "The quick brown fox jumps over the lazy dog." 13))
