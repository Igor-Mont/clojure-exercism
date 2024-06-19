(ns exercism-clojure.run_length_encoding
  (:require [clojure.string :as str]))

(defn is-digit-or-space?
  [c]
  ;(println "teste" (str c) "to string" (or (Character/isDigit c) (= " " (str c))))
  (or (Character/isDigit c)))

(defn repeat-n-str
  [[n s]]
  (apply str (apply str (repeat (Integer/parseInt n) (nth s 0))) (rest s)))

(defn run-length-decode
  "encodes a string with run-length-encoding"
  [plain-text]
  (if (some #(Character/isDigit %) plain-text)
    (->> plain-text
         (partition-by #(or (Character/isLetter %) (= " " (str %))))
         (map str/join)
         (partition-all 2)
         (map repeat-n-str)
         (map #(apply str %))
         str/join
         ) plain-text))

(defn run-length-encode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (partition-by identity)
       (map #(str (if (= 1 (count %)) "" (count %)) (nth % 0)))
       str/join
       )
  )

;(println (run-length-encode "AABCCCDEEEE"))
;(println (run-length-decode "12WB12W3B24WBA"))
;(println (run-length-decode "2 hs2q q2w2 "))
(println (run-length-decode "2 hs2q q2w2 "))
