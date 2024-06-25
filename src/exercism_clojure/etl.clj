(ns exercism_clojure.etl
  (:require [clojure.string :as str]))

(defn map-values [[points words]]
  (->> words
       (map #(hash-map (str/lower-case %) points))
       ))

(defn transform [old-data-format]
  (into {}
        (for [[score letters] old-data-format letter letters]
          [(str/lower-case letter) score])))


(println (transform {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]}))
