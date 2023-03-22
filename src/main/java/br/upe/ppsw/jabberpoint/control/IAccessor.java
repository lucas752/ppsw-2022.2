package br.upe.ppsw.jabberpoint.control;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.model.Presentation;

public interface IAccessor {
	  abstract public void loadFile(Presentation presentation, String fileName) throws IOException;

	  abstract public void saveFile(Presentation presentation, String fileName) throws IOException;
}
