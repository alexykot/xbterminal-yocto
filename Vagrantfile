require 'yaml'

Vagrant.configure(2) do |config|
  settings = YAML::load_file("vagrant/default_settings.yml")
  begin
    settings.deep_merge!(YAML::load_file("vagrant/settings.yml"))
  rescue Errno::ENOENT
  end

  config.vm.box = "debian/contrib-jessie64"
  config.vm.hostname = "xbt-build"

  config.vm.provider "virtualbox" do |vb|
    vb.name = "XBTerminal Build"
    vb.gui = settings['vm']['gui']
    vb.memory = settings['vm']['memory']
    vb.cpus = settings['vm']['cpus']

    # Enable USB
    if settings['vm']['usb']
      vb.customize ['modifyvm', :id, '--usb', 'on']
    end

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
        '--size', settings['vm']['disk_size'] * 1024  # Convert GB to MB
      ]
    end
    vb.customize [
      'storageattach', :id,
      '--storagectl', 'SATA Controller',
      '--port', 1,
      '--device', 0,
      '--type', 'hdd',
      '--medium', second_disk
    ]
  end

  config.vm.provision "shell", path: "vagrant/add_disk.sh"
  config.vm.provision "shell", path: "vagrant/provision.sh"
end
