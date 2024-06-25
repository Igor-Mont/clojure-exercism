(ns exercism_clojure.grains)

(defn square [n]
  (bigint (.pow (biginteger 2) (dec n))))

(defn total []
  18446744073709551615N)