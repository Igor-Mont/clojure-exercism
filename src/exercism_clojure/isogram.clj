(ns exercism-clojure.isogram)

(defn isogram? [s]
  (let [fmt-str (map #(Character/toLowerCase %)
                     (filter #(Character/isLetter %) s))
        freq (frequencies fmt-str)]
    (= (count freq) (reduce + 0 (vals freq))))
  )

(println (isogram? "Emily Jung Schwartzkopf"))
