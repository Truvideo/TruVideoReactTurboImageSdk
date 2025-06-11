import TruvideoReactTurboImageSdk from './NativeTruvideoReactTurboImageSdk';

export function launchImageEdit(
  inputPath: string,
  outputPath: string
): Promise<string> {
  return TruvideoReactTurboImageSdk.launchImageEdit(inputPath, outputPath);
}

export function getFilePath(fileName: string): Promise<string> {
  return TruvideoReactTurboImageSdk.getFilePath(fileName);
}

export function getInfo(imagePath: string): Promise<string> {
  return TruvideoReactTurboImageSdk.getInfo(imagePath);
}

export interface CropInformation {
  left: number;
  top: number;
  width: number;
  height: number;
}

export enum OutputFormat {
  PNG = 'PNG',
  JPG = 'JPG',
}
export function edit(
  imagePath: string,
  resultPath: string,
  rotation: string,
  cropInformation: CropInformation,
  horizontalFlip: boolean,
  verticalFlip: boolean,
  width: number,
  height: number,
  outputFormat: OutputFormat,
  compressionQuality: number
): Promise<string> {
  let mainOutput;
  if (outputFormat == OutputFormat.JPG) {
    mainOutput = 'JPG';
  } else {
    mainOutput = 'PNG';
  }
  var crop = {
    left: cropInformation.left,
    top: cropInformation.top,
    width: cropInformation.width,
    height: cropInformation.height,
  };
  return TruvideoReactTurboImageSdk.edit(
    imagePath,
    resultPath,
    rotation,
    JSON.stringify(crop),
    horizontalFlip,
    verticalFlip,
    width,
    height,
    mainOutput,
    compressionQuality
  );
}
