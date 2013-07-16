(ns znurgl.clojure.textprocessor.core-test
  (:use clojure.test
        znurgl.clojure.textprocessor.core))

; Testing irrelevant character remover functionality
(deftest rm-irrelevant-test
  (testing
    (is (.equals "simple" (rm-irrelevant "\"(si:m\nple.)\"")))))
