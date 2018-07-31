(ns giggin.fb.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]
            [giggin.fb.auth :refer [on-auth-state-changed]]))

(defn firebase-init
  []
  (if (zero? (alength firebase/apps))
    (firebase/initializeApp
     #js {:apiKey "AIzaSyA3Paue5zGJNavKGcG7TXJnNs1KhYdDlRs"
         :authDomain "giggin-4d4d7.firebaseapp.com"
         :databaseURL "https://giggin-4d4d7.firebaseio.com"
         :projectId "giggin-4d4d7"})
    (firebase/app))
  (on-auth-state-changed))
