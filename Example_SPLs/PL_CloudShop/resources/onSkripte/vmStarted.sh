#Skript zum Überprüfen, ob die Virtuelle Maschine schon vollständig #hochgefahren ist


#Unendliche While-Schleife zum Warten bis VM hoch gefahren ist
while (true) 
	do
	#sleep 1 damit keine schnelle Schleife den Computer belastet
	sleep 1

	#Zeige alle VMs und schreibe in die started.file
	onevm list>/var/lib/one/started.file

#Schneide die Zeile mit der bekannten VM $vm.name aus and schreibe #es in die Datei
	#here: ttylinux = $vm.name
	awk '/'$1'/ {print>"/var/lib/one/started.file"}' /var/lib/one/started.file
	
#Falls “runn” gefunden wurde, dann halte die Schleife an, weil die #VM läuft. Sonst mache weiter.
 	if (grep "runn" started.file >/dev/null)
		then
			exit 0
	fi
done
