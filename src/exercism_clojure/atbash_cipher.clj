(ns exercism-clojure.atbash_cipher
  (:require [clojure.string :as str]))

(defn get-cipher-by-plain
  [c]
  (let [plain "abcdefghijklmnopqrstuvwxyz"
        cipher "zyxwvutsrqponmlkjihgfedcba"
        index-of-c (str/index-of plain c)]
    (println (str/index-of plain c))
    (if index-of-c (nth cipher index-of-c) c)
    ))

;(println (get-cipher-by-plain "n"))

(defn chunk-plain
  [s]
    (if (>= (count s) 5)
      (partition-all 5 s) (conj [] (take (count s) s))))


;(println (chunk-plain plain))

(defn filter-by-is-letter-or-digit
  [c]
  (println c (class c) (int c))
  (Character/isLetterOrDigit (int c)))

(defn format-plain
  [s]
  (str/lower-case (apply str (filter filter-by-is-letter-or-digit s)))
  )


(defn encode
  [plain]
  (str/join " "
            (map #(str/join ""
                            (map get-cipher-by-plain %)) (chunk-plain (format-plain plain))))
  )

(println (encode "Testing, 1 2 3, testing."))

;(println (encode "thequickbrownfoxjumpsoverthelazydog"))











