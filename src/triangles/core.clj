(ns triangles.core
  (:require (clojure [string :as s])))

(defn alternate [large small]
  (cons (first large) (interleave small (rest large))))

(defn max-pair [pairs]
  (let [[x y] pairs]
    (max (apply + x) (apply + y))))

(defn generate-pairs [large small]
  (partition 2 (partition 2 1 (alternate large small))))

(defn max-sum [triangle]
  (cond
    (next triangle) (recur (cons (map max-pair (generate-pairs (first triangle) (second triangle))) (next (next triangle))))
    (first triangle) (first (first triangle))
    :else 0))

(defn parse-file [file-name]
  (for [r (drop-while #(empty? (s/trim %)) (s/split-lines (slurp (str "resources/" file-name))))]
    (map #(Integer/parseInt %) (s/split r #" "))))
