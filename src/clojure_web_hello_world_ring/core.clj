(ns clojure-web-hello-world-ring.core
    (:use ring.adapter.jetty))
(defn app [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body    "Hello World!"})
(defn -main [] (run-jetty #'app {:port 8080}))
