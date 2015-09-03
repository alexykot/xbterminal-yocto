Vagrant.configure(2) do |config|
  config.vm.box = "debian/jessie64"  # Supports card reader
  config.vm.hostname = "xbt-build"
  config.ssh.username = "vagrant"
  config.ssh.password = "vagrant"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "XBTerminal Build"
    vb.gui = true
    vb.memory = 2048
    vb.cpus = 2

    # Enable USB 2.0
    vb.customize ['modifyvm', :id, '--usb', 'on']
    vb.customize ['modifyvm', :id, '--usbehci', 'on']

    # Get disk path
    line = `VBoxManage list systemproperties | grep "Default machine folder"`
    vb_machine_folder = line.split(':')[1].strip()
    second_disk = File.join(vb_machine_folder, vb.name, 'disk2.vdi')

    # Create and attach disk
    unless File.exist?(second_disk)
      vb.customize [
        'createhd',
        '--filename', second_disk,
        '--format', 'VDI', 
        '--size', 90 * 1024  # 90 GB
      ]
    end
    vb.customize [
      'storageattach', :id,
      '--storagectl', 'IDE Controller',
      '--port', 0,
      '--device', 1,
      '--type', 'hdd',
      '--medium', second_disk
    ]
  end

  config.vm.provision "shell", path: "add_disk.sh"
  config.vm.provision "shell", path: "provision.sh"
end
