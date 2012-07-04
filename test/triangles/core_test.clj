(ns triangles.core-test
  (:use clojure.test
        triangles.core))

(deftest empy-triangle-test
  (testing "An empty triangle should sum to zero."
    (is (= 0 (max-sum [])))))

(deftest single-row-triangle-test
  (testing "A triangle with a single row must evalulate to the value in the row."
    (is (= 5 (max-sum [[5]])))))

(deftest two-rows-test
  (testing "Two rows must be merged into a single row with a single value."
    (is (= 27 (max-sum [[22 19] [5]])))))

(deftest many-rows
  (testing "Many rows must be merged into a single row with a single value."
    (is (= 27 (max-sum [[11 13 13] [9 6] [5]])))))
