(ns exercism-clojure.birdWatcher)

(def last-week [0, 2, 5, 3, 7, 8, 4])

(defn today
  [birds]
  (last birds)
  )

(defn inc-bird
  [birds]
  (update birds (- (count birds) 1) inc)
  )

(defn day-without-birds?
  [birds]
  (if (some zero? birds) true false)
  )

(defn n-days-count
  [birds n]
  (reduce + (subvec birds 0 n))
  )

(defn busy-days
  [birds]
  (count (filter #(>= % 5) birds))
  )

(defn odd-week?
  [birds]
  (let
    [index-value-map (map vector (range) birds),
     even-vector (map second (filter #(even? (first %)) index-value-map)),
     odd-vector (map second (filter #(odd? (first %)) index-value-map))]
    (and (every? #(= % 1) even-vector) (every? zero? odd-vector))
    )
  )

(println (odd-week? [1 0 1 0 1 0 1]))
