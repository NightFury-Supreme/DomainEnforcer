# DomainEnforcer - Minecraft Plugin

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Minecraft Versions](https://img.shields.io/badge/Minecraft-1.8%20--%201.20-green.svg)

**DomainEnforcer** is an open-source Minecraft plugin designed to enforce domain-based connections to your Minecraft server. Ensure your players connect using only approved domains and receive friendly reminders if they attempt to join using an IP address or an unapproved domain.

## Features

- **Domain Enforcement:** Players can only connect using specified domains, enhancing security and control.
- **Configurable Messages:** Customize the messages displayed to players who connect using an IP address or an unapproved domain.
- **Command Control:** Easily start, stop, and reload the plugin using in-game commands.
- **Version Compatibility:** Fully compatible with Minecraft versions from 1.8 to 1.20, ensuring a wide range of server support.

## Commands

- `/domainenforcer reload` - Reload the configuration.
- `/domainenforcer start` - Start the DomainEnforcer plugin.
- `/domainenforcer stop` - Stop the DomainEnforcer plugin.
- `/domainenforcer help` - Display help information.

## Permissions

- **domainenforcer.reload** - Allows access to the `/domainenforcer reload` command.
- **domainenforcer.start** - Allows access to the `/domainenforcer start` command.
- **domainenforcer.stop** - Allows access to the `/domainenforcer stop` command.
- **domainenforcer.help** - Allows access to the `/domainenforcer help` command.

## Configuration

Edit the `config.yml` file to set up your required domains and custom messages:

```yaml
# List of required domains players should use to connect add more domains as needed
required-domains:
  - yourdomain.com
  - anotherdomain.com

# Message to display when a player connects using an IP address
ip-warning-message:
  - "---------------------------------------------"
  - "&cYou have connected using an IP address."
  - "&ePlease use one of the following domains to connect:"
  - "&a- yourdomain.com"
  - "&a- anotherdomain.com"
  - "---------------------------------------------"

# Message to display when a player connects using an invalid domain
invalid-domain-message:
  - "---------------------------------------------"
  - "&cYou have connected using an invalid domain."
  - "&ePlease use one of the following domains to connect:"
  - "&a- yourdomain.com"
  - "&a- anotherdomain.com"
  - "---------------------------------------------"
```

## Installation

1. Download the plugin jar file and place it in your server's `plugins` directory.
2. Start or restart your server.
3. Configure the `config.yml` file to set your desired domains and messages.
4. Use the commands to manage the plugin in-game.

## Building from Source

To build DomainEnforcer from source, follow these steps:

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository/domainenforcer.git
   cd domainenforcer
   ```

2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

3. The compiled jar file will be located in the `target` directory.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes. Make sure to follow the project's coding standards and include appropriate tests for your new features or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Support

For support, feature requests, or to report bugs, please visit our [GitHub Issues](https://github.com/NightFury-Supreme/DomainEnforcer/issues) page.

---

**DomainEnforcer** is the perfect solution for server administrators who want to ensure that players connect using specified domains, providing a professional and controlled environment for your Minecraft community. Download now and take control of your server connections!
